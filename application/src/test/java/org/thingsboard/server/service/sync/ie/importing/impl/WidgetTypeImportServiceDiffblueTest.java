package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.sync.ie.WidgetTypeExportData;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class WidgetTypeImportServiceDiffblueTest {
  /**
   * Test
   * {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)}
   * with {@code EntitiesImportCtx}, {@code WidgetTypeExportData},
   * {@code WidgetTypeDetails}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails) with 'EntitiesImportCtx', 'WidgetTypeExportData', 'WidgetTypeDetails', 'WidgetTypeDetails'")
  void testCompareWithEntitiesImportCtxWidgetTypeExportDataWidgetTypeDetailsWidgetTypeDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeImportService widgetTypeImportService = new WidgetTypeImportService(new WidgetTypeServiceImpl());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetTypeExportData exportData = new WidgetTypeExportData();
    WidgetTypeDetails prepared = new WidgetTypeDetails();

    // Act and Assert
    assertTrue(widgetTypeImportService.compare(ctx, exportData, prepared, new WidgetTypeDetails()));
  }

  /**
   * Test
   * {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)}
   * with {@code EntitiesImportCtx}, {@code WidgetTypeExportData},
   * {@code WidgetTypeDetails}, {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeImportService#compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, WidgetTypeExportData, WidgetTypeDetails, WidgetTypeDetails) with 'EntitiesImportCtx', 'WidgetTypeExportData', 'WidgetTypeDetails', 'WidgetTypeDetails'")
  void testCompareWithEntitiesImportCtxWidgetTypeExportDataWidgetTypeDetailsWidgetTypeDetails2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeImportService widgetTypeImportService = new WidgetTypeImportService(mock(WidgetTypeServiceImpl.class));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    WidgetTypeExportData exportData = new WidgetTypeExportData();
    WidgetTypeDetails prepared = new WidgetTypeDetails();

    // Act and Assert
    assertTrue(widgetTypeImportService.compare(ctx, exportData, prepared, new WidgetTypeDetails()));
  }

  /**
   * Test {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)} with
   * {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetTypeDetails) with 'WidgetTypeDetails'")
  void testDeepCopyWithWidgetTypeDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeImportService widgetTypeImportService = new WidgetTypeImportService(mock(WidgetTypeService.class));
    WidgetTypeDetails widgetsBundle = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetsBundle, widgetTypeImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)} with
   * {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code Fqn}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetTypeDetails) with 'WidgetTypeDetails'; given 'true'; then return 'Fqn'")
  void testDeepCopyWithWidgetTypeDetails_givenTrue_thenReturnFqn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeImportService widgetTypeImportService = new WidgetTypeImportService(new WidgetTypeServiceImpl());
    WidgetTypeDetails widgetsBundle = mock(WidgetTypeDetails.class);
    when(widgetsBundle.isDeprecated()).thenReturn(true);
    when(widgetsBundle.isScada()).thenReturn(true);
    MissingNode instance = MissingNode.getInstance();
    when(widgetsBundle.getDescriptor()).thenReturn(instance);
    when(widgetsBundle.getVersion()).thenReturn(1L);
    when(widgetsBundle.getFqn()).thenReturn("Fqn");
    when(widgetsBundle.getName()).thenReturn("Name");
    when(widgetsBundle.getDescription()).thenReturn("The characteristics of someone or something");
    when(widgetsBundle.getImage()).thenReturn("Image");
    when(widgetsBundle.getTags()).thenReturn(new String[]{"Tags"});
    when(widgetsBundle.getCreatedTime()).thenReturn(1L);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(widgetsBundle.getTenantId()).thenReturn(tenantId);
    UUID id = UUID.randomUUID();
    WidgetTypeId widgetTypeId = new WidgetTypeId(id);
    when(widgetsBundle.getId()).thenReturn(widgetTypeId);
    WidgetTypeId widgetTypeId2 = new WidgetTypeId(UUID.randomUUID());
    when(widgetsBundle.getExternalId()).thenReturn(widgetTypeId2);

    // Act
    WidgetTypeDetails actualDeepCopyResult = widgetTypeImportService.deepCopy(widgetsBundle);

    // Assert
    verify(widgetsBundle).getCreatedTime();
    verify(widgetsBundle).getFqn();
    verify(widgetsBundle).getId();
    verify(widgetsBundle).getName();
    verify(widgetsBundle).getTenantId();
    verify(widgetsBundle).getVersion();
    verify(widgetsBundle).isDeprecated();
    verify(widgetsBundle).isScada();
    verify(widgetsBundle).getDescriptor();
    verify(widgetsBundle).getDescription();
    verify(widgetsBundle).getExternalId();
    verify(widgetsBundle).getImage();
    verify(widgetsBundle).getTags();
    assertEquals("Fqn", actualDeepCopyResult.getFqn());
    assertEquals("Image", actualDeepCopyResult.getImage());
    assertEquals("Name", actualDeepCopyResult.getName());
    assertEquals("The characteristics of someone or something", actualDeepCopyResult.getDescription());
    assertEquals(1L, actualDeepCopyResult.getVersion().longValue());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertTrue(actualDeepCopyResult.isDeprecated());
    assertTrue(actualDeepCopyResult.isScada());
    assertSame(tenantId, actualDeepCopyResult.getTenantId());
    assertSame(widgetTypeId, actualDeepCopyResult.getId());
    assertSame(widgetTypeId2, actualDeepCopyResult.getExternalId());
    assertSame(instance, actualDeepCopyResult.getDescriptor());
    assertSame(id, actualDeepCopyResult.getUuidId());
    assertArrayEquals(new String[]{"Tags"}, actualDeepCopyResult.getTags());
  }

  /**
   * Test {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)} with
   * {@code WidgetTypeDetails}.
   * <ul>
   *   <li>Then return {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeImportService#deepCopy(WidgetTypeDetails)}
   */
  @Test
  @DisplayName("Test deepCopy(WidgetTypeDetails) with 'WidgetTypeDetails'; then return WidgetTypeDetails()")
  void testDeepCopyWithWidgetTypeDetails_thenReturnWidgetTypeDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeImportService widgetTypeImportService = new WidgetTypeImportService(new WidgetTypeServiceImpl());
    WidgetTypeDetails widgetsBundle = new WidgetTypeDetails();

    // Act and Assert
    assertEquals(widgetsBundle, widgetTypeImportService.deepCopy(widgetsBundle));
  }

  /**
   * Test {@link WidgetTypeImportService#getEntityType()}.
   * <p>
   * Method under test: {@link WidgetTypeImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.WIDGET_TYPE, (new WidgetTypeImportService(new WidgetTypeServiceImpl())).getEntityType());
  }
}
