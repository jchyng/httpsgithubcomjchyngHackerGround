package com.hackerground.crawlingnotiserver.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.hackerground.crawlingnotiserver.dto.FCMMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class FCMNotificationService {
    private final FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(FCMMessage fcmMessage) {

        //title = Notification Test
        //body = Test Success!!!
        //image url = "https://github-production-user-asset-6210df.s3.amazonaws.com/76997735/246674603-9022cae3-450a-4b46-a723-a26a909825ae.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20230618%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230618T153247Z&X-Amz-Expires=300&X-Amz-Signature=ca18a074233bac601fefbd73145ce735031ecd89f69afedf85bf336ae150fc5b&X-Amz-SignedHeaders=host&actor_id=76997735&key_id=0&repo_id=653518058";
        Message message = Message.builder()
                .setToken(fcmMessage.getMessage().getToken())
                .setNotification(fcmMessage.getMessage().getNotification())
                .build();

        try{
            firebaseMessaging.send(message);
            return "알림을 성공적으로 전송했습니다. targetUserId = " + fcmMessage.getMessage().getToken();
        } catch (FirebaseMessagingException e) {
            log.error(e.getMessage());
            return "알림 전송에 실패하였습니다. targetUserId = " + fcmMessage.getMessage().getToken();
        }
    }
}
