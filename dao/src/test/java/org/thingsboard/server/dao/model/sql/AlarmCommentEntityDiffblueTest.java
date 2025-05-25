package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AlarmCommentEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentEntity#AlarmCommentEntity()}
   *   <li>{@link AlarmCommentEntity#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlarmCommentEntity.<init>()", "java.lang.String AlarmCommentEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentEntity actualAlarmCommentEntity = new AlarmCommentEntity();

    // Assert
    assertEquals("AlarmCommentEntity()", actualAlarmCommentEntity.toString());
    assertNull(actualAlarmCommentEntity.getComment());
    assertNull(actualAlarmCommentEntity.getId());
    assertNull(actualAlarmCommentEntity.getUuid());
    assertNull(actualAlarmCommentEntity.getAlarmId());
    assertNull(actualAlarmCommentEntity.getUserId());
    assertNull(actualAlarmCommentEntity.getType());
    assertEquals(0L, actualAlarmCommentEntity.getCreatedTime());
  }
}
