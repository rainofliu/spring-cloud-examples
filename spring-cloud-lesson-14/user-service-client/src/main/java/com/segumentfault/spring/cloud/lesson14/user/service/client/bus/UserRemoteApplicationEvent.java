package com.segumentfault.spring.cloud.lesson14.user.service.client.bus;

import com.segumentfault.spring.cloud.lesson14.domain.User;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 *  用户{@link RemoteApplicationEvent}
 * @author ajin
 */

public class UserRemoteApplicationEvent extends RemoteApplicationEvent {

    public UserRemoteApplicationEvent() {
    }

    public UserRemoteApplicationEvent(User user, String originService, String destinationService) {
        super(user, originService, destinationService);
    }
}
