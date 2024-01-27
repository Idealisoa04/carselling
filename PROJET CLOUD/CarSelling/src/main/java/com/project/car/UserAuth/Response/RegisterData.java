package com.project.car.UserAuth.Response;

import com.project.car.UserAuth.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RegisterData {

    Role[] roles;
    // List<Service> services;
    // List<Supplier> supplier;

}
