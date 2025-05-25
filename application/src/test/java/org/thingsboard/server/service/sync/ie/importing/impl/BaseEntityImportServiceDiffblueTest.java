package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ContextConfiguration(classes = {IdProvider.class})
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BaseEntityImportServiceDiffblueTest {
  @MockBean
  private BaseEntityImportService baseEntityImportService;

  @MockBean
  private EntitiesImportCtx entitiesImportCtx;

  @MockBean
  private EntityImportResult<ExportableEntity<EntityId>> entityImportResult;

  @Autowired
  private IdProvider idProvider;

  /**
   * Test IdProvider {@link IdProvider#getInternalId(EntityId)} with {@code externalId}.
   * <p>
   * Method under test: {@link IdProvider#getInternalId(EntityId)}
   */
  @Test
  @DisplayName("Test IdProvider getInternalId(EntityId) with 'externalId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId IdProvider.getInternalId(EntityId)"})
  void testIdProviderGetInternalIdWithExternalId() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entitiesImportCtx.getInternalId(Mockito.<EntityId>any())).thenReturn(alarmId);

    // Act
    EntityId actualInternalId = idProvider
        .getInternalId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(entitiesImportCtx).getInternalId(isA(EntityId.class));
    assertSame(alarmId, actualInternalId);
  }

  /**
   * Test IdProvider {@link IdProvider#getInternalId(EntityId, boolean)} with {@code externalId}, {@code throwExceptionIfNotFound}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdProvider#getInternalId(EntityId, boolean)}
   */
  @Test
  @DisplayName("Test IdProvider getInternalId(EntityId, boolean) with 'externalId', 'throwExceptionIfNotFound'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId IdProvider.getInternalId(EntityId, boolean)"})
  void testIdProviderGetInternalIdWithExternalIdThrowExceptionIfNotFound_whenNull() {
    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());

    // Act and Assert
    assertNull(
        (assetImportService.new IdProvider(entitiesImportCtx, new EntityImportResult())).getInternalId(null, true));
  }

  /**
   * Test IdProvider {@link IdProvider#getInternalId(EntityId)} with {@code externalId}.
   * <ul>
   *   <li>Given {@link EntitiesImportCtx}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdProvider#getInternalId(EntityId)}
   */
  @Test
  @DisplayName("Test IdProvider getInternalId(EntityId) with 'externalId'; given EntitiesImportCtx; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId IdProvider.getInternalId(EntityId)"})
  void testIdProviderGetInternalIdWithExternalId_givenEntitiesImportCtx_whenNull() {
    // Arrange, Act and Assert
    assertNull(idProvider.getInternalId(null));
  }
}
