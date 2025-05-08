package com.barbirms.service.implementations;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HabitMailService{

    @Autowired
    private JavaMailSender mailSender;

    public void sendReminder(User user, Habit habit, LocalDate date) {
        String subject = "Reminder: register habit \"" + habit.getName() + "\"";
        String body = """
            <html>
            <body>
                <p>Hello, %s!</p>
                <p>You haven't registered habit "%s" on %s.</p>
                <p><a href="%s">Register</a></p>
                <hr/>
                <p>Your HabitTracker</p>
            </body>
            </html>
            """.formatted(
                user.getUsername(),
                habit.getName(),
                date,
                "http://localhost:8080/fake-get/user/" + habit.getOwner().getUsername() + "/habit/" + habit.getName()+"/records"
        );

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("michael789234@gmail.com");
            helper.setTo(user.getEmail());
            helper.setSubject(subject);
            helper.setText(body, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Error sending message: " + e.getMessage(), e);
        }
    }
}
