package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

@ContextConfiguration(classes = {CustomerUsersEdgeEventFetcher.class, CustomerId.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CustomerUsersEdgeEventFetcherDiffblueTest {
  @Autowired
  private CustomerUsersEdgeEventFetcher customerUsersEdgeEventFetcher;

  @MockBean
  private UUID uUID;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link CustomerUsersEdgeEventFetcher#CustomerUsersEdgeEventFetcher(UserService, CustomerId)}.
   * <p>
   * Method under test:
   * {@link CustomerUsersEdgeEventFetcher#CustomerUsersEdgeEventFetcher(UserService, CustomerId)}
   */
  @Test
  @DisplayName("Test new CustomerUsersEdgeEventFetcher(UserService, CustomerId)")
  void testNewCustomerUsersEdgeEventFetcher() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    // Act and Assert
    UserService userService2 = (new CustomerUsersEdgeEventFetcher(userService,
        new CustomerId(UUID.randomUUID()))).userService;
    assertTrue(userService2 instanceof UserServiceImpl);
    assertEquals(EntityType.USER, userService2.getEntityType());
  }

  /**
   * Test {@link CustomerUsersEdgeEventFetcher#findUsers(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link CustomerUsersEdgeEventFetcher#findUsers(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findUsers(TenantId, PageLink)")
  void testFindUsers() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findCustomerUsers(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<User> actualFindUsersResult = customerUsersEdgeEventFetcher.findUsers(tenantId, new PageLink(3));

    // Assert
    verify(userService).findCustomerUsers(isA(TenantId.class), isA(CustomerId.class), isA(PageLink.class));
    assertSame(actualFindUsersResult.EMPTY_PAGE_DATA, actualFindUsersResult);
  }
}
