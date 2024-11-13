package org.thingsboard.server.service.entitiy.widgets.bundle;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;

class DefaultWidgetsBundleServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User); given WidgetTypeId(UUID) with id is randomUUID")
  void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsRandomUUID() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeService widgetTypeService = mock(WidgetTypeService.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetTypes(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<WidgetTypeId>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(UUID.randomUUID()));

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetTypes(widgetsBundleId, widgetTypeIds, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetTypes(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Given {@link WidgetTypeId#WidgetTypeId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User); given WidgetTypeId(UUID) with id is randomUUID")
  void testUpdateWidgetsBundleWidgetTypes_givenWidgetTypeIdWithIdIsRandomUUID2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeService widgetTypeService = mock(WidgetTypeService.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetTypes(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<WidgetTypeId>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());

    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();
    widgetTypeIds.add(new WidgetTypeId(UUID.randomUUID()));
    widgetTypeIds.add(new WidgetTypeId(UUID.randomUUID()));

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetTypes(widgetsBundleId, widgetTypeIds, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetTypes(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeService#updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetTypes(WidgetsBundleId, List, User); then calls updateWidgetsBundleWidgetTypes(TenantId, WidgetsBundleId, List)")
  void testUpdateWidgetsBundleWidgetTypes_thenCallsUpdateWidgetsBundleWidgetTypes() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeService widgetTypeService = mock(WidgetTypeService.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetTypes(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<WidgetTypeId>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());
    ArrayList<WidgetTypeId> widgetTypeIds = new ArrayList<>();

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetTypes(widgetsBundleId, widgetTypeIds, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetTypes(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User); given 'foo'; when ArrayList() add 'foo'")
  void testUpdateWidgetsBundleWidgetFqns_givenFoo_whenArrayListAddFoo() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeServiceImpl widgetTypeService = mock(WidgetTypeServiceImpl.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetFqns(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<String>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("foo");
    widgetFqns.add("Operation not supported!");

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetFqns(widgetsBundleId, widgetFqns, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetFqns(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Given {@code Operation not supported!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User); given 'Operation not supported!'")
  void testUpdateWidgetsBundleWidgetFqns_givenOperationNotSupported() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeServiceImpl widgetTypeService = mock(WidgetTypeServiceImpl.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetFqns(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<String>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());

    ArrayList<String> widgetFqns = new ArrayList<>();
    widgetFqns.add("Operation not supported!");

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetFqns(widgetsBundleId, widgetFqns, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetFqns(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}.
   * <ul>
   *   <li>Then calls
   * {@link WidgetTypeServiceImpl#updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWidgetsBundleService#updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User)}
   */
  @Test
  @DisplayName("Test updateWidgetsBundleWidgetFqns(WidgetsBundleId, List, User); then calls updateWidgetsBundleWidgetFqns(TenantId, WidgetsBundleId, List)")
  void testUpdateWidgetsBundleWidgetFqns_thenCallsUpdateWidgetsBundleWidgetFqns() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeServiceImpl widgetTypeService = mock(WidgetTypeServiceImpl.class);
    doNothing().when(widgetTypeService)
        .updateWidgetsBundleWidgetFqns(Mockito.<TenantId>any(), Mockito.<WidgetsBundleId>any(),
            Mockito.<List<String>>any());
    DefaultWidgetsBundleService defaultWidgetsBundleService = new DefaultWidgetsBundleService(
        new WidgetsBundleServiceImpl(), widgetTypeService);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());
    ArrayList<String> widgetFqns = new ArrayList<>();

    // Act
    defaultWidgetsBundleService.updateWidgetsBundleWidgetFqns(widgetsBundleId, widgetFqns, new User());

    // Assert
    verify(widgetTypeService).updateWidgetsBundleWidgetFqns(isNull(), isA(WidgetsBundleId.class), isA(List.class));
  }
}
