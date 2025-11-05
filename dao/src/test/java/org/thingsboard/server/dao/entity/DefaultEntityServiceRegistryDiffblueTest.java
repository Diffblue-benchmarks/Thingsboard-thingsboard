package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;

@ContextConfiguration(classes = {DefaultEntityServiceRegistry.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultEntityServiceRegistryDiffblueTest {
  @Autowired private DefaultEntityServiceRegistry defaultEntityServiceRegistry;

  @MockBean private EntityDaoService entityDaoService;

  @Autowired private List<EntityDaoService> list;

  /**
   * Test {@link DefaultEntityServiceRegistry#init()}.
   *
   * <ul>
   *   <li>Given {@link EntityDaoService} {@link EntityDaoService#getEntityType()} return {@code
   *       RULE_CHAIN}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#init()}
   */
  @Test
  @DisplayName("Test init(); given EntityDaoService getEntityType() return 'RULE_CHAIN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEntityServiceRegistry.init()"})
  void testInit_givenEntityDaoServiceGetEntityTypeReturnRuleChain() {
    // Arrange
    when(entityDaoService.getEntityType()).thenReturn(EntityType.RULE_CHAIN);

    // Act
    defaultEntityServiceRegistry.init();

    // Assert
    verify(entityDaoService).getEntityType();
  }

  /**
   * Test {@link DefaultEntityServiceRegistry#init()}.
   *
   * <ul>
   *   <li>Given {@link EntityDaoService} {@link EntityDaoService#getEntityType()} return {@code
   *       TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#init()}
   */
  @Test
  @DisplayName("Test init(); given EntityDaoService getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultEntityServiceRegistry.init()"})
  void testInit_givenEntityDaoServiceGetEntityTypeReturnTenant() {
    // Arrange
    when(entityDaoService.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultEntityServiceRegistry.init();

    // Assert
    verify(entityDaoService).getEntityType();
  }

  /**
   * Test {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}.
   *
   * <p>Method under test: {@link DefaultEntityServiceRegistry#getServiceByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getServiceByEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityDaoService DefaultEntityServiceRegistry.getServiceByEntityType(EntityType)"
  })
  void testGetServiceByEntityType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultEntityServiceRegistry.getServiceByEntityType(EntityType.TENANT));
  }
}
