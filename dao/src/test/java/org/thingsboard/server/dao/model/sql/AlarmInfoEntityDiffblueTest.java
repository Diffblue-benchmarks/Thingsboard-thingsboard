package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AlarmInfoEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmInfoEntity}
   *   <li>{@link AlarmInfoEntity#setAssigneeEmail(String)}
   *   <li>{@link AlarmInfoEntity#setAssigneeFirstName(String)}
   *   <li>{@link AlarmInfoEntity#setAssigneeLastName(String)}
   *   <li>{@link AlarmInfoEntity#setOriginatorLabel(String)}
   *   <li>{@link AlarmInfoEntity#setOriginatorName(String)}
   *   <li>{@link AlarmInfoEntity#setStatus(String)}
   *   <li>{@link AlarmInfoEntity#toString()}
   *   <li>{@link AlarmInfoEntity#getAssigneeEmail()}
   *   <li>{@link AlarmInfoEntity#getAssigneeFirstName()}
   *   <li>{@link AlarmInfoEntity#getAssigneeLastName()}
   *   <li>{@link AlarmInfoEntity#getOriginatorLabel()}
   *   <li>{@link AlarmInfoEntity#getOriginatorName()}
   *   <li>{@link AlarmInfoEntity#getStatus()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlarmInfoEntity.<init>()", "String AlarmInfoEntity.getAssigneeEmail()",
      "String AlarmInfoEntity.getAssigneeFirstName()", "String AlarmInfoEntity.getAssigneeLastName()",
      "String AlarmInfoEntity.getOriginatorLabel()", "String AlarmInfoEntity.getOriginatorName()",
      "String AlarmInfoEntity.getStatus()", "void AlarmInfoEntity.setAssigneeEmail(String)",
      "void AlarmInfoEntity.setAssigneeFirstName(String)", "void AlarmInfoEntity.setAssigneeLastName(String)",
      "void AlarmInfoEntity.setOriginatorLabel(String)", "void AlarmInfoEntity.setOriginatorName(String)",
      "void AlarmInfoEntity.setStatus(String)", "String AlarmInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmInfoEntity actualAlarmInfoEntity = new AlarmInfoEntity();
    actualAlarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    actualAlarmInfoEntity.setAssigneeFirstName("Jane");
    actualAlarmInfoEntity.setAssigneeLastName("Doe");
    actualAlarmInfoEntity.setOriginatorLabel("Originator Label");
    actualAlarmInfoEntity.setOriginatorName("Originator Name");
    actualAlarmInfoEntity.setStatus("Status");
    String actualToStringResult = actualAlarmInfoEntity.toString();
    String actualAssigneeEmail = actualAlarmInfoEntity.getAssigneeEmail();
    String actualAssigneeFirstName = actualAlarmInfoEntity.getAssigneeFirstName();
    String actualAssigneeLastName = actualAlarmInfoEntity.getAssigneeLastName();
    String actualOriginatorLabel = actualAlarmInfoEntity.getOriginatorLabel();
    String actualOriginatorName = actualAlarmInfoEntity.getOriginatorName();

    // Assert
    assertEquals(
        "AlarmInfoEntity(originatorName=Originator Name, originatorLabel=Originator Label, assigneeFirstName=Jane,"
            + " assigneeLastName=Doe, assigneeEmail=jane.doe@example.org, status=Status)",
        actualToStringResult);
    assertEquals("Doe", actualAssigneeLastName);
    assertEquals("Jane", actualAssigneeFirstName);
    assertEquals("Originator Label", actualOriginatorLabel);
    assertEquals("Originator Name", actualOriginatorName);
    assertEquals("Status", actualAlarmInfoEntity.getStatus());
    assertEquals("jane.doe@example.org", actualAssigneeEmail);
    assertNull(actualAlarmInfoEntity.getDetails());
    assertNull(actualAlarmInfoEntity.getPropagate());
    assertNull(actualAlarmInfoEntity.getPropagateToOwner());
    assertNull(actualAlarmInfoEntity.getPropagateToTenant());
    assertNull(actualAlarmInfoEntity.getAckTs());
    assertNull(actualAlarmInfoEntity.getAssignTs());
    assertNull(actualAlarmInfoEntity.getClearTs());
    assertNull(actualAlarmInfoEntity.getEndTs());
    assertNull(actualAlarmInfoEntity.getStartTs());
    assertNull(actualAlarmInfoEntity.getPropagateRelationTypes());
    assertNull(actualAlarmInfoEntity.getType());
    assertNull(actualAlarmInfoEntity.getId());
    assertNull(actualAlarmInfoEntity.getUuid());
    assertNull(actualAlarmInfoEntity.getAssigneeId());
    assertNull(actualAlarmInfoEntity.getCustomerId());
    assertNull(actualAlarmInfoEntity.getOriginatorId());
    assertNull(actualAlarmInfoEntity.getTenantId());
    assertNull(actualAlarmInfoEntity.getOriginatorType());
    assertNull(actualAlarmInfoEntity.getSeverity());
    assertEquals(0L, actualAlarmInfoEntity.getCreatedTime());
    assertFalse(actualAlarmInfoEntity.isAcknowledged());
    assertFalse(actualAlarmInfoEntity.isCleared());
  }
}
