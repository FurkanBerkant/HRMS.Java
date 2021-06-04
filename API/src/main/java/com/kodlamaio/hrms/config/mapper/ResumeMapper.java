package com.kodlamaio.hrms.config.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.kodlamaio.hrms.entities.Dtos.ResumeGetDto;
import com.kodlamaio.hrms.entities.Dtos.ResumePostDto;
import com.kodlamaio.hrms.entities.concretes.Resume;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

	ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

	@Mapping(source = "edcschoolName", target = "education.schoolName")

	@Mapping(source = "edcschoolDepartment", target = "education.schoolDepartment")

	@Mapping(source = "edcstartedDate", target = "education.startedDate")

	@Mapping(source = "grdDescription", target = "education.graduate.description")

	@Mapping(source = "expcompanyName", target = "jobExperiences.companyName")

	@Mapping(source = "expstartedDate", target = "jobExperiences.startedDate")

	@Mapping(source = "expendedDate", target = "jobExperiences.endedDate")

	@Mapping(source = "expjobTitleId", target = "jobExperiences.jobTitle.id")

	@Mapping(source = "jobSeekerId", target = "jobSeeker.id")

	@Mapping(source = "languagelevel", target = "languages.langLevel")

	@Mapping(source = "language", target = "languages.language")

	@Mapping(source = "techDescription", target = "technologies.description")

	Resume map(ResumePostDto resumeRequestDto);

	@Named("toGetDto")
	ResumeGetDto map(Resume resume);

	@IterableMapping(qualifiedByName = "togGetDto")
	List<ResumeGetDto> map(List<Resume> resumes);
}
