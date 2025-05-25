package org.thingsboard.server.dao.mobile;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.oauth2.OAuth2ClientDao;

@ContextConfiguration(classes = {MobileAppServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class MobileAppServiceImplDiffblueTest {
  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private MobileAppDao mobileAppDao;

  @Autowired
  private MobileAppServiceImpl mobileAppServiceImpl;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}.
   * <ul>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppServiceImpl#deleteMobileAppById(TenantId, MobileAppId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteMobileAppById(TenantId, MobileAppId)"})
  public void testDeleteMobileAppById_thenCallsRemoveById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(mobileAppDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppById(ModelConstants.SYSTEM_TENANT,
        new MobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(mobileAppDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link MobileAppServiceImpl#deleteMobileAppsByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteMobileAppsByTenantId(TenantId)"})
  public void testDeleteMobileAppsByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteMobileAppsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link MobileAppServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(mobileAppDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    mobileAppServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link MobileAppServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType MobileAppServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.MOBILE_APP, (new MobileAppServiceImpl()).getEntityType());
  }
}
