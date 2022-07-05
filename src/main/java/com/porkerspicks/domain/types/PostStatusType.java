package com.porkerspicks.domain.types;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum PostStatusType {

    UNSAVED,
    DRAFT,
    PUBLISHED;

    @Override
    public String toString() {
        return StringUtils.capitalize( super.toString().toLowerCase(Locale.ROOT) );
    }
}
