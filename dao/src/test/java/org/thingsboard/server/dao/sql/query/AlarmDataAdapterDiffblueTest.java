package org.thingsboard.server.dao.sql.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.EntityDataPageLink;

public class AlarmDataAdapterDiffblueTest {
  /**
   * Test {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}.
   * <ul>
   *   <li>When {@link EntityDataPageLink#EntityDataPageLink()}.</li>
   *   <li>Then return TotalPages is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataAdapter#createAlarmData(EntityDataPageLink, List, int, Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData AlarmDataAdapter.createAlarmData(EntityDataPageLink, List, int, Collection)"})
  public void testCreateAlarmData_whenEntityDataPageLink_thenReturnTotalPagesIsOne() {
    // Arrange
    EntityDataPageLink pageLink = new EntityDataPageLink();
    ArrayList<Map<String, Object>> rows = new ArrayList<>();

    // Act
    PageData<AlarmData> actualCreateAlarmDataResult = AlarmDataAdapter.createAlarmData(pageLink, rows, 1,
        new ArrayList<>());

    // Assert
    assertEquals(1, actualCreateAlarmDataResult.getTotalPages());
    assertEquals(1L, actualCreateAlarmDataResult.getTotalElements());
    assertFalse(actualCreateAlarmDataResult.hasNext());
    assertTrue(actualCreateAlarmDataResult.getData().isEmpty());
  }
}
