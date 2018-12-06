package com.string.edits.repository;

import com.string.edits.domain.Language;
import com.string.edits.persistence.repository.LanguageRepository;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultLanguageRepository implements LanguageRepository {

//    private Logger LOG = LoggerFactory.getLogger(DefaultLanguageRepository.class);

    private Map<String, Language> languageRepository;

    public DefaultLanguageRepository(Map<String, Language> languageRepository) {
        this.languageRepository = languageRepository;
    }

    public void save(Language language) {
        languageRepository.put(language.getName(), language);
    }

    public void addPatternToLanguage(String languageName, String pattern) {
        Language languageEntity = languageRepository.get(languageName);
        if (languageEntity == null) {
//            LOG.error("Language not found in repository for {}", languageName);
            return;
        } else {
            languageEntity.addPattern(pattern);
            save(languageEntity);
        }
    }

    public void delete(String languageName) {
        languageRepository.remove(languageName);
    }

    @Override
    public Language findLanguage(String name) {
        return languageRepository.get(name);
    }
}
