package com.acc.somsomparty.domain.User.entity;

import com.acc.somsomparty.domain.Reservation.entity.Reservation;
import com.acc.somsomparty.domain.User.enums.Role;
import com.acc.somsomparty.domain.chatting.entity.UserChatRoom;
import com.acc.somsomparty.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
//    ALTER TABLE users DROP COLUMN password;
//    @Column(nullable = true)
//    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserChatRoom> userChatRooms = new ArrayList<>();
}
