package com.swifty.service.education.education.service.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseDTO {
    private Long userId;
    private Long courseId;
}
