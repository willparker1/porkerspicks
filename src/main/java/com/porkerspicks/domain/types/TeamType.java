package com.porkerspicks.domain.types;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public enum TeamType {
    ABERDEEN,
    AIRDRIEONIANS,
    ALBION_ROVERS,
    ALLOA_ATHLETIC,
    ANNAN_ATHLETIC,
    ARBROATH,
    AYR_UNITED,
    BRECHIN_CITY,
    CELTIC,
    CLYDE,
    COWDENBEATH,
    DUMBARTON,
    DUNDEE,
    DUNDEE_UNITED,
    DUNFERMLINE_ATHLETIC,
    EAST_FIFE,
    ELGIN_CITY,
    FALKIRK,
    FORFAR_ATHLETIC,
    HAMILTON_ACADEMICAL,
    HEART_OF_MIDLOTHIAN,
    HIBERNIAN,
    INVERNESS_CALEDONIAN_THISTLE,
    KILMARNOCK,
    LIVINGSTON,
    MONTROSE,
    MORTON,
    MOTHERWELL,
    PARTICK_THISTLE,
    PETERHEAD,
    QUEEN_OF_THE_SOUTH,
    QUEENS_PARK,
    RAITH_ROVERS,
    RANGERS,
    ROSS_COUNTY,
    ST_JOHNSTONE,
    ST_MIRREN,
    STENHOUSEMUIR,
    STIRLING_ALBION,
    STRANRAER;

    @Override
    public String toString() {
        return StringUtils.capitalize( super.toString().toLowerCase(Locale.ROOT) );
    }
}
