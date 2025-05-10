package com.kafka.consumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Employee {

    @Id
    private String id;

    private String gender;
    private String age;
    private String profession;
    private String academicPressure;
    private String WorkPressure;
    private String CGPA;
    private String StudySatisfaction;
    private String JobSatisfaction;
    private String SleepDuration;
    private String DietaryHabits;
    private String degree;
    private String suicidal;
    private String studyHour;
    private String mentalIllnessHistory;
    private String depression;
    private String financialStress;
    private String city;
    private String workStudyHours;
    private Date updatedDate;

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAcademicPressure() {
        return academicPressure;
    }

    public void setAcademicPressure(String academicPressure) {
        this.academicPressure = academicPressure;
    }

    public String getWorkPressure() {
        return WorkPressure;
    }

    public void setWorkPressure(String workPressure) {
        WorkPressure = workPressure;
    }

    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    public String getStudySatisfaction() {
        return StudySatisfaction;
    }

    public void setStudySatisfaction(String studySatisfaction) {
        StudySatisfaction = studySatisfaction;
    }

    public String getJobSatisfaction() {
        return JobSatisfaction;
    }

    public void setJobSatisfaction(String jobSatisfaction) {
        JobSatisfaction = jobSatisfaction;
    }

    public String getSleepDuration() {
        return SleepDuration;
    }

    public void setSleepDuration(String sleepDuration) {
        SleepDuration = sleepDuration;
    }

    public String getDietaryHabits() {
        return DietaryHabits;
    }

    public void setDietaryHabits(String dietaryHabits) {
        DietaryHabits = dietaryHabits;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSuicidal() {
        return suicidal;
    }

    public void setSuicidal(String suicidal) {
        this.suicidal = suicidal;
    }

    public String getStudyHour() {
        return studyHour;
    }

    public void setStudyHour(String studyHour) {
        this.studyHour = studyHour;
    }

    public String getMentalIllnessHistory() {
        return mentalIllnessHistory;
    }

    public void setMentalIllnessHistory(String mentalIllnessHistory) {
        this.mentalIllnessHistory = mentalIllnessHistory;
    }

    public String getDepression() {
        return depression;
    }

    public void setDepression(String depression) {
        this.depression = depression;
    }

    public String getFinancialStress() {
        return financialStress;
    }

    public void setFinancialStress(String financialStress) {
        this.financialStress = financialStress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorkStudyHours() {
        return workStudyHours;
    }

    public void setWorkStudyHours(String workStudyHours) {
        this.workStudyHours = workStudyHours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", profession='" + profession + '\'' +
                ", academicPressure='" + academicPressure + '\'' +
                ", WorkPressure='" + WorkPressure + '\'' +
                ", CGPA='" + CGPA + '\'' +
                ", StudySatisfaction='" + StudySatisfaction + '\'' +
                ", JobSatisfaction='" + JobSatisfaction + '\'' +
                ", SleepDuration='" + SleepDuration + '\'' +
                ", DietaryHabits='" + DietaryHabits + '\'' +
                ", degree='" + degree + '\'' +
                ", suicidal='" + suicidal + '\'' +
                ", studyHour='" + studyHour + '\'' +
                ", mentalIllnessHistory='" + mentalIllnessHistory + '\'' +
                ", depression='" + depression + '\'' +
                ", financialStress='" + financialStress + '\'' +
                ", city='" + city + '\'' +
                ", workStudyHours='" + workStudyHours + '\'' +
                '}';
    }
}
