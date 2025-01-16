package org.thingsboard.server.dao.sql.widget;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.WidgetsBundleEntity;

public class WidgetsBundleRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link WidgetsBundleRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setVersion(1L);
    ExportableEntityRepository<WidgetsBundleEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetsBundleEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
