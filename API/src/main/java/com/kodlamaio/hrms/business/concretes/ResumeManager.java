package com.kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.config.mapper.ResumeMapper;
import com.kodlamaio.hrms.core.utilities.cloudinary.abstracts.CloudinaryService;
import com.kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import com.kodlamaio.hrms.entities.Dtos.ResumeGetDto;
import com.kodlamaio.hrms.entities.Dtos.ResumeRequestDto;
import com.kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DtoConverterService dtoConverterService;
	@Autowired
	private CloudinaryService cloudinaryService;

	@Override
	public DataResult<List<ResumeGetDto>> getAll() {
		return new SuccessDataResult<List<ResumeGetDto>>
		(dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeGetDto.class) , "resumes listed successfully");
	}

	@Override
	public Result add(ResumeRequestDto resumeRequestDto) {
		//Resume resume = ResumeMapper.INSTANCE.map(resumeRequestDto);
		// resume.getJobExperiences().forEach(jobExperience->jobExperience.setResume(resume));
		// resume.getEducation().forEach(education->education.setResume(resume));
		// resume.getLanguages().forEach(languages->languages.setResume(resume));
		// resume.getTechnologies().forEach(technologies->technologies.setResume(resume));

		// resumeHelperService.setAllResumeId(resume.getEducation(),
		// resume.getLanguages(), resume.getTechnologies(),
		// resume.getJobExperiences(), resume);
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeRequestDto, Resume.class));
		//ResumeMapper.INSTANCE.map(resumeDao.save(resume));
		return new SuccessResult("resume successfully added");
	}

	@Override
	public DataResult<List<Resume>> findAllJobSeekerById(int jobSeekerId) {
		// List<Resume> resumes = resumeDao.findAllByJobSeekerId(jobSeekerId);
		return new SuccessDataResult<List<Resume>>(resumeDao.findAllByJobSeekerId(jobSeekerId));
	}

	private List<ResumeRequestDto> resumeToDto(List<Resume> resumes) {
		return resumes.stream().map(resume -> modelMapper.map(resume, ResumeRequestDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhotoUrl(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");

	}

}
