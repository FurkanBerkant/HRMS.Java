package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.ResumeGetDto;
import com.kodlamaio.hrms.entities.Dtos.ResumePostDto;
import com.kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	DataResult<List<ResumeGetDto>> getAll();

	Result add(ResumePostDto resumeRequestDto);

	DataResult<List<Resume>> findAllJobSeekerById(int jobSeekerId);

	Result saveImage(MultipartFile file, int resumeId);
}
