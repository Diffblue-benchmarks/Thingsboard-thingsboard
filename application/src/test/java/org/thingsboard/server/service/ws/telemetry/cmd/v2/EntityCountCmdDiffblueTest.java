package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityCountQuery;
import org.thingsboard.server.service.ws.WsCmdType;

class EntityCountCmdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountCmd#EntityCountCmd(int, EntityCountQuery)}
   *   <li>{@link EntityCountCmd#getQuery()}
   *   <li>{@link EntityCountCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCountCmd.<init>(int, EntityCountQuery)", "EntityCountQuery EntityCountCmd.getQuery()",
      "WsCmdType EntityCountCmd.getType()"})
  void testGettersAndSetters() {
    // Arrange
    EntityCountQuery query = new EntityCountQuery();

    // Act
    EntityCountCmd actualEntityCountCmd = new EntityCountCmd(1, query);
    EntityCountQuery actualQuery = actualEntityCountCmd.getQuery();
    WsCmdType actualType = actualEntityCountCmd.getType();

    // Assert
    assertEquals(1, actualEntityCountCmd.getCmdId());
    assertEquals(WsCmdType.ENTITY_COUNT, actualType);
    assertSame(query, actualQuery);
  }
}
