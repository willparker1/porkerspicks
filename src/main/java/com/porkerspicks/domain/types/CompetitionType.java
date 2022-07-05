package com.porkerspicks.domain.types;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum CompetitionType {

    PREMIERSHIP,
    CHAMPIONSHIP,
    LEAGUE_ONE,
    LEAGUE_TWO,
    DIDDY_CUP,
    SCOTTISH_CUP,
    LEAGUE_CUP,
    CHAMPIONS_LEAGUE,
    EUROPA_EAGUE,
    CONFERENCE_LEAGUE,
    WORLD_CUP_QUALIFIERS,
    NATIONS_LEAGUE,
    EURO_QUALIFIERS,
    WORLD_CUP,
    EURO_CHAMPIONSHIPS;

    @Override
    public String toString() {
        return StringUtils.capitalize( super.toString().toLowerCase(Locale.ROOT) );
    }
}
