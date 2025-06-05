package com.npo.domain;

import java.util.List;

public record WebUser(String username, List<String> roles) {
}
