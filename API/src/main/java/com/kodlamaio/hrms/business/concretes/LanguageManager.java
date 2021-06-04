package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import com.kodlamaio.hrms.entities.Dtos.LanguageDto;
import com.kodlamaio.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private DtoConverterService dtoConverterService;
	@Override
	public DataResult<List<LanguageDto>> getAll() {
		return new SuccessDataResult<List<LanguageDto>>
		(dtoConverterService.dtoConverter(languageDao.findAll(), LanguageDto.class),"languages listed successfully");
	}

	@Override
	public Result add(@Valid LanguageDto languageDto) {
		languageDao.save((Language) dtoConverterService.dtoClassConverter
				(languageDto, Language.class));
		return new SuccessResult("language successfully added");
	}
}
