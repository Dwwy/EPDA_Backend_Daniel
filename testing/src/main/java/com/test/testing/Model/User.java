package com.test.testing.Model;

import com.test.testing.Util.StaticVariable;
import com.test.testing.Util.TextEncryptor;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(schema = "User")
@Data
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;
    @Column(unique=true)
    private String email;
    private LocalDateTime creationDate = LocalDateTime.now();
    private StaticVariable.accountType accountType;
    private String password;
    public String getPassword(){
        TextEncryptor encryptor = new TextEncryptor(StaticVariable.authenticator_secret());
        return encryptor.decrypt(this.password);
    }
    public void setPassword(String text){
        TextEncryptor encryptor = new TextEncryptor(StaticVariable.authenticator_secret());
        String pass = encryptor.encrypt(text);
        this.password = pass;
    }
}
