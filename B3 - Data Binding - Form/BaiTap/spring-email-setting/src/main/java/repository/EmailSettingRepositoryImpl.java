package repository;

import model.EmailSetting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailSettingRepositoryImpl implements EmailSettingRepository {
    private static final Map<Integer, EmailSetting> emailsettings;

    static {
        emailsettings = new HashMap<>();
        emailsettings.put(1, new EmailSetting(1,"english","25","spamfiller","once upon a time"));
    }

    @Override
    public List<EmailSetting> findAll() {
        return new ArrayList<>(emailsettings.values());

    }

    @Override
    public void save(EmailSetting email) {
        emailsettings.put(email.getId(), email);
    }


    @Override
    public EmailSetting findById(int id) {
        return emailsettings.get(id);
    }
}
