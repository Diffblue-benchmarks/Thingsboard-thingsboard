package org.thingsboard.server.service.mobile.secret;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.cache.TbCacheValueWrapper;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

@ContextConfiguration(classes = {MobileAppSecretServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MobileAppSecretServiceImplDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @Autowired
  private MobileAppSecretServiceImpl mobileAppSecretServiceImpl;

  @MockBean
  private SecuritySettingsService securitySettingsService;

  @MockBean
  private TbTransactionalCache<String, JwtPair> tbTransactionalCache;

  /**
   * Test {@link MobileAppSecretServiceImpl#getJwtPair(String)}.
   * <p>
   * Method under test: {@link MobileAppSecretServiceImpl#getJwtPair(String)}
   */
  @Test
  @DisplayName("Test getJwtPair(String)")
  void testGetJwtPair() throws ThingsboardException {
    // Arrange
    TbCacheValueWrapper<JwtPair> tbCacheValueWrapper = mock(TbCacheValueWrapper.class);
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    when(tbCacheValueWrapper.get()).thenReturn(jwtPair);
    when(tbTransactionalCache.get(Mockito.<String>any())).thenReturn(tbCacheValueWrapper);

    // Act
    JwtPair actualJwtPair = mobileAppSecretServiceImpl.getJwtPair("Secret");

    // Assert
    verify(tbCacheValueWrapper).get();
    verify(tbTransactionalCache).get(eq("Secret"));
    assertSame(jwtPair, actualJwtPair);
  }

  /**
   * Test
   * {@link MobileAppSecretServiceImpl#handleEvictEvent(MobileSecretEvictEvent)}
   * with {@code MobileSecretEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSecretServiceImpl#handleEvictEvent(MobileSecretEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(MobileSecretEvictEvent) with 'MobileSecretEvictEvent'; then calls evict(Serializable)")
  void testHandleEvictEventWithMobileSecretEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    mobileAppSecretServiceImpl.handleEvictEvent(new MobileSecretEvictEvent("Secret"));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(eq("Secret"));
  }
}
