package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;

class DeviceProfileAlarmDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceProfileAlarm}
   *   <li>{@link DeviceProfileAlarm#setAlarmType(String)}
   *   <li>{@link DeviceProfileAlarm#setCreateRules(TreeMap)}
   *   <li>{@link DeviceProfileAlarm#setId(String)}
   *   <li>{@link DeviceProfileAlarm#setPropagate(boolean)}
   *   <li>{@link DeviceProfileAlarm#setPropagateRelationTypes(List)}
   *   <li>{@link DeviceProfileAlarm#setPropagateToOwner(boolean)}
   *   <li>{@link DeviceProfileAlarm#setPropagateToTenant(boolean)}
   *   <li>{@link DeviceProfileAlarm#toString()}
   *   <li>{@link DeviceProfileAlarm#getAlarmType()}
   *   <li>{@link DeviceProfileAlarm#getClearRule()}
   *   <li>{@link DeviceProfileAlarm#getCreateRules()}
   *   <li>{@link DeviceProfileAlarm#getId()}
   *   <li>{@link DeviceProfileAlarm#getPropagateRelationTypes()}
   *   <li>{@link DeviceProfileAlarm#isPropagate()}
   *   <li>{@link DeviceProfileAlarm#isPropagateToOwner()}
   *   <li>{@link DeviceProfileAlarm#isPropagateToTenant()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileAlarm.<init>()",
    "String DeviceProfileAlarm.getAlarmType()",
    "AlarmRule DeviceProfileAlarm.getClearRule()",
    "TreeMap DeviceProfileAlarm.getCreateRules()",
    "String DeviceProfileAlarm.getId()",
    "List DeviceProfileAlarm.getPropagateRelationTypes()",
    "boolean DeviceProfileAlarm.isPropagate()",
    "boolean DeviceProfileAlarm.isPropagateToOwner()",
    "boolean DeviceProfileAlarm.isPropagateToTenant()",
    "void DeviceProfileAlarm.setAlarmType(String)",
    "void DeviceProfileAlarm.setClearRule(AlarmRule)",
    "void DeviceProfileAlarm.setCreateRules(TreeMap)",
    "void DeviceProfileAlarm.setId(String)",
    "void DeviceProfileAlarm.setPropagate(boolean)",
    "void DeviceProfileAlarm.setPropagateRelationTypes(List)",
    "void DeviceProfileAlarm.setPropagateToOwner(boolean)",
    "void DeviceProfileAlarm.setPropagateToTenant(boolean)",
    "String DeviceProfileAlarm.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceProfileAlarm actualDeviceProfileAlarm = new DeviceProfileAlarm();
    actualDeviceProfileAlarm.setAlarmType("Alarm Type");
    TreeMap<AlarmSeverity, AlarmRule> createRules = new TreeMap<>();
    actualDeviceProfileAlarm.setCreateRules(createRules);
    actualDeviceProfileAlarm.setId("42");
    actualDeviceProfileAlarm.setPropagate(true);
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    actualDeviceProfileAlarm.setPropagateRelationTypes(propagateRelationTypes);
    actualDeviceProfileAlarm.setPropagateToOwner(true);
    actualDeviceProfileAlarm.setPropagateToTenant(true);
    String actualToStringResult = actualDeviceProfileAlarm.toString();
    String actualAlarmType = actualDeviceProfileAlarm.getAlarmType();
    AlarmRule actualClearRule = actualDeviceProfileAlarm.getClearRule();
    TreeMap<AlarmSeverity, AlarmRule> actualCreateRules = actualDeviceProfileAlarm.getCreateRules();
    String actualId = actualDeviceProfileAlarm.getId();
    List<String> actualPropagateRelationTypes =
        actualDeviceProfileAlarm.getPropagateRelationTypes();
    boolean actualIsPropagateResult = actualDeviceProfileAlarm.isPropagate();
    boolean actualIsPropagateToOwnerResult = actualDeviceProfileAlarm.isPropagateToOwner();
    boolean actualIsPropagateToTenantResult = actualDeviceProfileAlarm.isPropagateToTenant();

    // Assert
    assertEquals("42", actualId);
    assertEquals("Alarm Type", actualAlarmType);
    assertEquals(
        "DeviceProfileAlarm(id=42, alarmType=Alarm Type, createRules={}, clearRule=null, propagate=true,"
            + " propagateToOwner=true, propagateToTenant=true, propagateRelationTypes=[])",
        actualToStringResult);
    assertNull(actualClearRule);
    assertTrue(actualPropagateRelationTypes.isEmpty());
    assertTrue(actualIsPropagateResult);
    assertTrue(actualIsPropagateToOwnerResult);
    assertTrue(actualIsPropagateToTenantResult);
    assertSame(propagateRelationTypes, actualPropagateRelationTypes);
    assertSame(createRules, actualCreateRules);
  }
}
