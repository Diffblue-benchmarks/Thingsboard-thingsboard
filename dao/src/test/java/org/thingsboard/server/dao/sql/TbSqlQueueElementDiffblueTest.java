package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TbSqlQueueElementDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlQueueElement#TbSqlQueueElement(SettableFuture, Object)}
   *   <li>{@link TbSqlQueueElement#toString()}
   *   <li>{@link TbSqlQueueElement#getEntity()}
   *   <li>{@link TbSqlQueueElement#getFuture()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlQueueElement.<init>(SettableFuture, Object)", "Object TbSqlQueueElement.getEntity()",
      "SettableFuture TbSqlQueueElement.getFuture()", "String TbSqlQueueElement.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    SettableFuture<Object> future = SettableFuture.create();

    // Act
    TbSqlQueueElement<Object, Object> actualTbSqlQueueElement = new TbSqlQueueElement<>(future, "Entity");
    String actualToStringResult = actualTbSqlQueueElement.toString();
    Object actualEntity = actualTbSqlQueueElement.getEntity();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("TbSqlQueueElement(entity=Entity)", actualToStringResult);
    assertSame(future, actualTbSqlQueueElement.getFuture());
  }
}
