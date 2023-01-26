package it.epicode.exercise;

import java.time.LocalDate;

public class Student {

	private Integer id;
	private String name;
	private String lastname;
	private Gender gender;
	private LocalDate birthdate;
	private Double avg;
	private Integer minVote;
	private Integer maxVote;
	
	public Student(String name, String lastname, Gender gender, LocalDate birthdate, Double avg, Integer minVote, Integer maxVote) {
		this.name=name;
		this.lastname=lastname;
		this.gender=gender;
		this.birthdate=birthdate;
		this.avg=avg;
		this.minVote=minVote;
		this.maxVote=maxVote;
	}

	public Student(Integer id, String name, String lastname, Gender gender, LocalDate birthdate, Double avg, Integer minVote, Integer maxVote) {
		this.id=id;
		this.name=name;
		this.lastname=lastname;
		this.gender=gender;
		this.birthdate=birthdate;
		this.avg=avg;
		this.minVote=minVote;
		this.maxVote=maxVote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Integer getMinVote() {
		return minVote;
	}

	public void setMinVote(Integer minVote) {
		this.minVote = minVote;
	}

	public Integer getMaxVote() {
		return maxVote;
	}

	public void setMaxVote(Integer maxVote) {
		this.maxVote = maxVote;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastname=" + lastname + ", gender=" + gender + ", birthdate="
				+ birthdate + ", avg=" + avg + ", minVote=" + minVote + ", maxVote=" + maxVote + "]";
	}
}
