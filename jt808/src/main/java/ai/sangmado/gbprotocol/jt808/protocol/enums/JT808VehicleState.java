package ai.sangmado.gbprotocol.jt808.protocol.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * JT/T 808 车辆状态位定义
 */
@Getter
public enum JT808VehicleState {
    JT808_Vehicle_State_0(1, JT808ProtocolVersion.V2011, "ACC开"),
    JT808_Vehicle_State_1(1 << 1, JT808ProtocolVersion.V2011, "定位"),
    JT808_Vehicle_State_2(1 << 2, JT808ProtocolVersion.V2011, "南纬"),
    JT808_Vehicle_State_3(1 << 3, JT808ProtocolVersion.V2011, "西经"),
    JT808_Vehicle_State_4(1 << 4, JT808ProtocolVersion.V2011, "停运状态"),
    JT808_Vehicle_State_5(1 << 5, JT808ProtocolVersion.V2011, "经纬度已经保密插件加密"),
    JT808_Vehicle_State_6(1 << 6, JT808ProtocolVersion.V2019, "紧急刹车系统采集的前撞预警"),
    JT808_Vehicle_State_7(1 << 7, JT808ProtocolVersion.V2019, "车道偏移预警"),
    JT808_Vehicle_State_8_01(1 << 8, JT808ProtocolVersion.V2013, "半载，00空车，01半载"),
    JT808_Vehicle_State_9_11(1 << 9 + 1 << 8, JT808ProtocolVersion.V2013, "满载，10保留，11满载"),
    JT808_Vehicle_State_10(1 << 10, JT808ProtocolVersion.V2011, "车辆油路断开"),
    JT808_Vehicle_State_11(1 << 11, JT808ProtocolVersion.V2011, "车辆电路断开"),
    JT808_Vehicle_State_12(1 << 12, JT808ProtocolVersion.V2011, "车门加锁"),
    JT808_Vehicle_State_13(1 << 13, JT808ProtocolVersion.V2013, "门1开，前门"),
    JT808_Vehicle_State_14(1 << 14, JT808ProtocolVersion.V2013, "门2开，中门"),
    JT808_Vehicle_State_15(1 << 15, JT808ProtocolVersion.V2013, "门3开，后门"),
    JT808_Vehicle_State_16(1 << 16, JT808ProtocolVersion.V2013, "门4开，驾驶席门"),
    JT808_Vehicle_State_17(1 << 17, JT808ProtocolVersion.V2013, "门5开，自定义"),
    JT808_Vehicle_State_18(1 << 18, JT808ProtocolVersion.V2013, "使用GPS卫星进行定位"),
    JT808_Vehicle_State_19(1 << 19, JT808ProtocolVersion.V2013, "使用北斗卫星进行定位"),
    JT808_Vehicle_State_20(1 << 20, JT808ProtocolVersion.V2013, "使用GLONASS卫星进行定位"),
    JT808_Vehicle_State_21(1 << 21, JT808ProtocolVersion.V2013, "使用Galileo卫星进行定位"),
    JT808_Vehicle_State_22(1 << 22, JT808ProtocolVersion.V2019, "车辆处于行驶状态"),
    JT808_Vehicle_State_23(1 << 23, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_24(1 << 24, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_25(1 << 25, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_26(1 << 26, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_27(1 << 27, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_28(1 << 28, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_29(1 << 29, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_30(1 << 20, JT808ProtocolVersion.V2011, "保留"),
    JT808_Vehicle_State_31(1 << 31, JT808ProtocolVersion.V2011, "保留"),
    ;

    @JsonInclude
    private Long value;

    @JsonIgnore
    private JT808ProtocolVersion since;

    @JsonIgnore
    private String description;

    JT808VehicleState(long value, JT808ProtocolVersion since, String description) {
        this.value = value;
        this.since = since;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name();
    }

    private static final Map<Long, JT808VehicleState> mapping = new HashMap<>();

    static {
        for (JT808VehicleState item : values()) {
            mapping.put(item.getValue(), item);
        }
    }

    public static JT808VehicleState cast(long value) {
        JT808VehicleState item = mapping.get(value);
        if (item == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot cast long [%s] to [%s] enum.",
                    value, JT808VehicleState.class.getSimpleName()));
        }
        return item;
    }

    public static JT808VehicleState parse(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        for (JT808VehicleState item : values()) {
            if (item.name().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
