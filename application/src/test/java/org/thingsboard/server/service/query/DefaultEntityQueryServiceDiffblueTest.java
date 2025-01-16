package org.thingsboard.server.service.query;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.AlarmDataPageLink;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.data.query.EntityDataSortOrder;
import org.thingsboard.server.common.data.query.EntityFilter;
import org.thingsboard.server.common.data.query.EntityKey;
import org.thingsboard.server.common.data.query.KeyFilter;
import org.thingsboard.server.service.security.model.SecurityUser;

class DefaultEntityQueryServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEntityQueryService#findAlarmDataByQuery(SecurityUser, AlarmDataQuery)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityQueryService#findAlarmDataByQuery(SecurityUser, AlarmDataQuery)}
   */
  @Test
  @DisplayName("Test findAlarmDataByQuery(SecurityUser, AlarmDataQuery); then throw RuntimeException")
  void testFindAlarmDataByQuery_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityQueryService defaultEntityQueryService = new DefaultEntityQueryService();
    SecurityUser securityUser = mock(SecurityUser.class);
    EntityDataSortOrder entityDataSortOrder = mock(EntityDataSortOrder.class);
    when(entityDataSortOrder.getKey()).thenThrow(new RuntimeException("foo"));
    AlarmDataPageLink pageLink = mock(AlarmDataPageLink.class);
    when(pageLink.getSortOrder()).thenReturn(entityDataSortOrder);
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<EntityKey> entityFields = new ArrayList<>();
    ArrayList<EntityKey> latestValues = new ArrayList<>();
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultEntityQueryService.findAlarmDataByQuery(securityUser,
        new AlarmDataQuery(entityFilter, pageLink, entityFields, latestValues, keyFilters, new ArrayList<>())));
    verify(pageLink).getSortOrder();
    verify(entityDataSortOrder).getKey();
  }
}
