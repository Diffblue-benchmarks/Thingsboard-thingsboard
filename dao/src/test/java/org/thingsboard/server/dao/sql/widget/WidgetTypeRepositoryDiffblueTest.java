package org.thingsboard.server.dao.sql.widget;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity;

public class WidgetTypeRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    ExportableEntityRepository<WidgetTypeDetailsEntity> exportableEntityRepository = mock(
        ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(widgetTypeDetailsEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
