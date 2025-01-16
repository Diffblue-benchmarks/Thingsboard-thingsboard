package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.sync.ie.WidgetsBundleExportData;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class WidgetsBundleImportServiceDiffblueTest {
  /**
   * Test
   * {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)}
   * with {@code EntitiesImportCtx}, {@code WidgetsBundleExportData},
   * {@code WidgetsBundle}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle) with 'EntitiesImportCtx', 'WidgetsBundleExportData', 'WidgetsBundle', 'WidgetsBundle'")
  void testCompareWithEntitiesImportCtxWidgetsBundleExportDataWidgetsBundleWidgetsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    WidgetsBundleImportService widgetsBundleImportService = new WidgetsBundleImportService(widgetsBundleService,
        new WidgetTypeServiceImpl());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetsBundleExportData exportData = new WidgetsBundleExportData();
    WidgetsBundle prepared = new WidgetsBundle();

    // Act and Assert
    assertTrue(widgetsBundleImportService.compare(ctx, exportData, prepared, new WidgetsBundle()));
  }

  /**
   * Test
   * {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)}
   * with {@code EntitiesImportCtx}, {@code WidgetsBundleExportData},
   * {@code WidgetsBundle}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleImportService#compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetsBundleExportData, WidgetsBundle, WidgetsBundle) with 'EntitiesImportCtx', 'WidgetsBundleExportData', 'WidgetsBundle', 'WidgetsBundle'")
  void testCompareWithEntitiesImportCtxWidgetsBundleExportDataWidgetsBundleWidgetsBundle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = mock(WidgetsBundleServiceImpl.class);
    WidgetsBundleImportService widgetsBundleImportService = new WidgetsBundleImportService(widgetsBundleService,
        new WidgetTypeServiceImpl());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetsBundleExportData exportData = new WidgetsBundleExportData();
    WidgetsBundle prepared = new WidgetsBundle();

    // Act and Assert
    assertTrue(widgetsBundleImportService.compare(ctx, exportData, prepared, new WidgetsBundle()));
  }

  /**
   * Test {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)} with
   * {@code WidgetsBundle}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetsBundle) with 'WidgetsBundle'")
  void testDeepCopyWithWidgetsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleService widgetsBundleService = mock(WidgetsBundleService.class);
    WidgetsBundleImportService widgetsBundleImportService = new WidgetsBundleImportService(widgetsBundleService,
        new WidgetTypeServiceImpl());
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertEquals(widgetsBundle, widgetsBundleImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)} with
   * {@code WidgetsBundle}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code Alias}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetsBundle) with 'WidgetsBundle'; given 'true'; then return 'Alias'")
  void testDeepCopyWithWidgetsBundle_givenTrue_thenReturnAlias() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    WidgetsBundleImportService widgetsBundleImportService = new WidgetsBundleImportService(widgetsBundleService,
        new WidgetTypeServiceImpl());
    WidgetsBundle widgetsBundle = mock(WidgetsBundle.class);
    when(widgetsBundle.isScada()).thenReturn(true);
    when(widgetsBundle.getOrder()).thenReturn(1);
    when(widgetsBundle.getVersion()).thenReturn(1L);
    when(widgetsBundle.getAlias()).thenReturn("Alias");
    when(widgetsBundle.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetsBundle.getImage()).thenReturn("Image");
    when(widgetsBundle.getTitle()).thenReturn("Dr");
    when(widgetsBundle.getCreatedTime()).thenReturn(1L);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    WidgetsBundleId widgetsBundleId = new WidgetsBundleId(UUID.randomUUID());
    when(widgetsBundle.getExternalId()).thenReturn(widgetsBundleId);
    UUID id = UUID.randomUUID();
    WidgetsBundleId widgetsBundleId2 = new WidgetsBundleId(id);
    when(widgetsBundle.getId()).thenReturn(widgetsBundleId2);

    // Act
    WidgetsBundle actualDeepCopyResult = widgetsBundleImportService.deepCopy(widgetsBundle);

    // Assert
    verify(widgetsBundle).getAlias();
    verify(widgetsBundle).getCreatedTime();
    verify(widgetsBundle).getDescription();
    verify(widgetsBundle).getExternalId();
    verify(widgetsBundle).getId();
    verify(widgetsBundle).getImage();
    verify(widgetsBundle).getOrder();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getTitle();
    verify(widgetsBundle).getVersion();
    verify(widgetsBundle).isScada();
    assertEquals("Alias", actualDeepCopyResult.getAlias());
    assertEquals("Dr", actualDeepCopyResult.getName());
    assertEquals("Dr", actualDeepCopyResult.getTitle());
    assertEquals("Image", actualDeepCopyResult.getImage());
    assertEquals("The characteristics of someone or something", actualDeepCopyResult.getDescription());
    assertEquals(1, actualDeepCopyResult.getOrder().intValue());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertTrue(actualDeepCopyResult.isScada());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(widgetsBundleId, actualDeepCopyResult.getExternalId());
    assertSame(widgetsBundleId2, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)} with
   * {@code WidgetsBundle}.
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.</li>
   *   <li>Then return {@link WidgetsBundle#WidgetsBundle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleImportService#deepCopy(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetsBundle) with 'WidgetsBundle'; when WidgetsBundle(); then return WidgetsBundle()")
  void testDeepCopyWithWidgetsBundle_whenWidgetsBundle_thenReturnWidgetsBundle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    WidgetsBundleImportService widgetsBundleImportService = new WidgetsBundleImportService(widgetsBundleService,
        new WidgetTypeServiceImpl());
    WidgetsBundle widgetsBundle = new WidgetsBundle();

    // Act and Assert
    assertEquals(widgetsBundle, widgetsBundleImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetsBundleImportService#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetsBundleImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();

    // Act and Assert
    assertEquals(EntityType.WIDGETS_BUNDLE,
        (new WidgetsBundleImportService(widgetsBundleService, new WidgetTypeServiceImpl())).getEntityType());
  }
}
