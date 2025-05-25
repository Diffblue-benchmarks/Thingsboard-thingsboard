package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AlarmEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmEntity#AlarmEntity()}
   *   <li>{@link AlarmEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlarmEntity.<init>()", "java.lang.String AlarmEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmEntity actualAlarmEntity = new AlarmEntity();

    // Assert
    assertEquals("AlarmEntity()", actualAlarmEntity.toString());
    assertNull(actualAlarmEntity.getDetails());
    assertNull(actualAlarmEntity.getPropagate());
    assertNull(actualAlarmEntity.getPropagateToOwner());
    assertNull(actualAlarmEntity.getPropagateToTenant());
    assertNull(actualAlarmEntity.getAckTs());
    assertNull(actualAlarmEntity.getAssignTs());
    assertNull(actualAlarmEntity.getClearTs());
    assertNull(actualAlarmEntity.getEndTs());
    assertNull(actualAlarmEntity.getStartTs());
    assertNull(actualAlarmEntity.getPropagateRelationTypes());
    assertNull(actualAlarmEntity.getType());
    assertNull(actualAlarmEntity.getId());
    assertNull(actualAlarmEntity.getUuid());
    assertNull(actualAlarmEntity.getAssigneeId());
    assertNull(actualAlarmEntity.getCustomerId());
    assertNull(actualAlarmEntity.getOriginatorId());
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(actualAlarmEntity.getOriginatorType());
    assertNull(actualAlarmEntity.getSeverity());
    assertEquals(0L, actualAlarmEntity.getCreatedTime());
    assertFalse(actualAlarmEntity.isAcknowledged());
    assertFalse(actualAlarmEntity.isCleared());
  }
}
