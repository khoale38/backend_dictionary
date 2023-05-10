package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.backenddictionnary.backend_dictionary.models.Option;
import com.example.backenddictionnary.backend_dictionary.repository.OptionRepository;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    QuestionService questionService;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Option> getAllOption() {
        return optionRepository.findAll();
    }

    public List<Option> getOptionsByQuestionId(String id) {
        var result = questionService.getQuestionById(id);
        if (result == null) {
            return null;
        }
        return optionRepository.findAllById(result.getOptions());
    }

    public Option addOption(Option option) {
        return optionRepository.save(option);
    }

    public void deleteOption(String id) {
        optionRepository.deleteById(id);
    }

    public Option editOption(Option option, String id) {
        Option findOption = optionRepository.findById(id).orElse(null);

        if (findOption != null) {
            findOption
                    .setValue(option.getValue() != null ? option.getValue() : findOption.getValue());

            findOption
                    .setCorrect(option.isCorrect());

            return optionRepository.save(findOption);
        }
        return null;

    }

}
