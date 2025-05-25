package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {OAuth2ClientServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuth2ClientServiceImplDiffblueTest {
  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<OAuth2Client> dataValidator;

  @MockBean
  private OAuth2ClientDao oAuth2ClientDao;

  @Autowired
  private OAuth2ClientServiceImpl oAuth2ClientServiceImpl;

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OAuth2ClientServiceImpl.findAppSecret(OAuth2ClientId, String)"})
  public void testFindAppSecret() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult = oAuth2ClientServiceImpl
        .findAppSecret(new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Pkg Name");

    // Assert
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}.
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#findAppSecret(OAuth2ClientId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OAuth2ClientServiceImpl.findAppSecret(OAuth2ClientId, String)"})
  public void testFindAppSecret_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientDao.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    String actualFindAppSecretResult = oAuth2ClientServiceImpl.findAppSecret(oAuth2ClientId, "Pkg Name");

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteOAuth2ClientById(TenantId, OAuth2ClientId)"})
  public void testDeleteOAuth2ClientById() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(oAuth2ClientDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOAuth2ClientById(ModelConstants.SYSTEM_TENANT,
        new OAuth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(oAuth2ClientDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#deleteOAuth2ClientById(TenantId, OAuth2ClientId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteOAuth2ClientById(TenantId, OAuth2ClientId)"})
  public void testDeleteOAuth2ClientById_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(oAuth2ClientDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    oAuth2ClientServiceImpl.deleteOAuth2ClientById(ModelConstants.SYSTEM_TENANT, oAuth2ClientId);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#deleteOauth2ClientsByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(TenantId)"})
  public void testDeleteOauth2ClientsByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteOauth2ClientsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link OAuth2ClientDao#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OAuth2ClientServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientDao).deleteByTenantId(Mockito.<UUID>any());

    // Act
    oAuth2ClientServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(oAuth2ClientDao).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link OAuth2ClientServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link OAuth2ClientServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType OAuth2ClientServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.OAUTH2_CLIENT, (new OAuth2ClientServiceImpl()).getEntityType());
  }
}
