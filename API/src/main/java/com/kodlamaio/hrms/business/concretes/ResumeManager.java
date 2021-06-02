package com.kodlamaio.hrms.business.concretes;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import com.kodlamaio.hrms.entities.Dtos.ResumeDto;
import com.kodlamaio.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>
		(this.resumeDao.findAll(),"resumes listed successfully");
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		Resume resume = modelMapper.map(resumeDto, Resume.class);
		resumeDao.save(resume);
		return new SuccessResult("resume successfully added");
	}

	@Override
	public DataResult<List<ResumeDto>> findAllJobSeekerById(int jobSeekerId) {
		List<Resume> resumes=resumeDao
				.findAllByJobSeekerId(jobSeekerId);
		return new SuccessDataResult<List<ResumeDto>>
		(resumeToDto(resumes));
	}
	
	private List<ResumeDto> resumeToDto(List<Resume> resumes){		
		return resumes.stream().map(resume->modelMapper.map(resume,ResumeDto.class))
				.collect(Collectors.toList());
}

}
