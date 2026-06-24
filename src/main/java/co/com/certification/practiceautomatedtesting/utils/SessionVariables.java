package co.com.certification.practiceautomatedtesting.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SessionVariables {
    SESSION_PRODUCT("product");
    private final String value;
}
