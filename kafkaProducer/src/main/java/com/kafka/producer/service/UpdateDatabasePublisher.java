package com.kafka.producer.service;

import com.common.dto.UserDto;
import com.kafka.producer.constant.ProducerTopic;
import com.kafka.producer.entity.User;
import com.kafka.producer.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UpdateDatabasePublisher {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String, UserDto> kafkaTemplate;

    @Autowired
    private RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(UpdateDatabasePublisher.class);

    public List<User> getTop10Result(){
        List<User> latestUsers = userRepository.findTop10ByIsReadOrderById(false);
        return latestUsers;
    }

    @Scheduled(fixedDelay = 10000)
    public void sendData(){
        List<User> users = getTop10Result();
        if ( users != null &&  !users.isEmpty()){
            sendUserInformation(users);
        }

        markUserColSendSuccessfully(users);
    }

    private void markUserColSendSuccessfully(List<User> users) {
        try{
            users.forEach(
                    user -> {
                        Optional<User> userOptional = userRepository.findById(user.getId());
                        if (userOptional.isPresent()){
                            User savedUser = userOptional.get();
                            savedUser.setRead(true);
                            savedUser.setDbUpdateSendDate(new Date());
                            userRepository.save(savedUser);
                        }
                    }
            );
        }catch (Exception e){
            e.printStackTrace();
            logger.info("something went wrong while updating the user-information");
        }
    }

    private void sendUserInformation(List<User> users) {
        if (users != null && !users.isEmpty()) {
            // this is conversion is required  to allow to consumer the object at kafka consumer end
            List<UserDto> userDtoList = users.stream()
                    .map(this::toDto)
                    .toList();

            try {
                for (UserDto userDto : userDtoList) {
                    kafkaTemplate.send(ProducerTopic.UPDATE_USER_TOPIC, userDto);
                }

//            try {
//                ResponseEntity<List> listResponseEntity = restTemplate.postForEntity(
//                        "http://localhost:8000/api/consumer/save",
//                        userHttpEmtity,
//                        List.class
//                );
            } catch (Exception e) {
                throw new RuntimeException("Error sending data, retrying...");
            }

        }
    }

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setGender(user.getGender());
        dto.setAge(user.getAge());
        dto.setProfession(user.getProfession());
        dto.setAcademicPressure(user.getAcademicPressure());
        dto.setWorkPressure(user.getWorkPressure());
        dto.setCGPA(user.getCGPA());
        dto.setStudySatisfaction(user.getStudySatisfaction());
        dto.setJobSatisfaction(user.getJobSatisfaction());
        dto.setSleepDuration(user.getSleepDuration());
        dto.setDietaryHabits(user.getDietaryHabits());
        dto.setDegree(user.getDegree());
        dto.setSuicidal(user.getSuicidal());
        dto.setStudyHour(user.getStudyHour());
        dto.setMentalIllnessHistory(user.getMentalIllnessHistory());
        dto.setDepression(user.getDepression());
        dto.setFinancialStress(user.getFinancialStress());
        dto.setCity(user.getCity());
        dto.setWorkStudyHours(user.getWorkStudyHours());
        dto.setDbUpdateSendDate(user.getDbUpdateSendDate());
        dto.setRead(user.isRead());
        return dto;
    }

}
