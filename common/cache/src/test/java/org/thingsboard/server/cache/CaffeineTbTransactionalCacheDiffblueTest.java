package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;

@ContextConfiguration
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CaffeineTbTransactionalCacheDiffblueTest {
  @Autowired
  private CaffeineTbTransactionalCache<CustomerCacheKey, Customer> caffeineTbTransactionalCache;

  @MockBean private CustomerCaffeineCache customerCaffeineCache;

  /**
   * Test {@link CaffeineTbTransactionalCache#get(Serializable)}.
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#get(Serializable)}
   */
  @Test
  @DisplayName("Test get(Serializable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbCacheValueWrapper CaffeineTbTransactionalCache.get(Serializable)"})
  void testGet() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());

    // Act
    TbCacheValueWrapper<Customer> actualGetResult =
        customerCaffeineCache.get(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"));

    // Assert
    Lock lock = customerCaffeineCache.lock;
    assertTrue(lock instanceof ReentrantLock);
    Cache cache = customerCaffeineCache.cache;
    assertTrue(cache instanceof CaffeineCache);
    assertEquals("customers", cache.getName());
    assertEquals("customers", customerCaffeineCache.getCacheName());
    assertNull(actualGetResult);
    assertEquals(0, ((ReentrantLock) lock).getHoldCount());
    assertEquals(0, ((ReentrantLock) lock).getQueueLength());
    assertFalse(((ReentrantLock) lock).hasQueuedThreads());
    assertFalse(((ReentrantLock) lock).isFair());
    assertFalse(((ReentrantLock) lock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) lock).isLocked());
    assertTrue(((CaffeineCache) cache).isAllowNullValues());
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#getCacheName()}.
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#getCacheName()}
   */
  @Test
  @DisplayName("Test getCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CaffeineTbTransactionalCache.getCacheName()"})
  void testGetCacheName() {
    // Arrange, Act and Assert
    assertEquals("customers", new CustomerCaffeineCache(new CaffeineCacheManager()).getCacheName());
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#get(Serializable)}.
   *
   * <ul>
   *   <li>Then return {@link SimpleTbCacheValueWrapper}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#get(Serializable)}
   */
  @Test
  @DisplayName("Test get(Serializable); then return SimpleTbCacheValueWrapper")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbCacheValueWrapper CaffeineTbTransactionalCache.get(Serializable)"})
  void testGet_thenReturnSimpleTbCacheValueWrapper() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Customer customer = new Customer();
    customerCaffeineCache.put(customerCacheKey, customer);
    CustomerCacheKey customerCacheKey2 =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    // Act
    TbCacheValueWrapper<Customer> actualGetResult = customerCaffeineCache.get(customerCacheKey2);
    Customer actualGetResult2 = actualGetResult.get();

    // Assert
    assertTrue(customerCaffeineCache.lock instanceof ReentrantLock);
    assertTrue(customerCaffeineCache.cache instanceof CaffeineCache);
    assertTrue(actualGetResult instanceof SimpleTbCacheValueWrapper);
    assertEquals("customers", customerCaffeineCache.getCacheName());
    assertEquals(customerCacheKey, customerCacheKey2);
    assertSame(customer, actualGetResult.get());
    assertSame(customer, actualGetResult2);
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#newTransactionForKey(Serializable)}.
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#newTransactionForKey(Serializable)}
   */
  @Test
  @DisplayName("Test newTransactionForKey(Serializable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbCacheTransaction CaffeineTbTransactionalCache.newTransactionForKey(Serializable)"
  })
  void testNewTransactionForKey() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    // Act
    TbCacheTransaction<CustomerCacheKey, Customer> actualNewTransactionForKeyResult =
        customerCaffeineCache.newTransactionForKey(customerCacheKey);

    // Assert
    assertTrue(actualNewTransactionForKeyResult instanceof CaffeineTbCacheTransaction);
    List<CustomerCacheKey> keys =
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeyResult)
            .getKeys();
    assertEquals(1, keys.size());
    assertFalse(
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeyResult)
            .isFailed());
    assertSame(customerCacheKey, keys.get(0));
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#newTransactionForKeys(List)}.
   *
   * <ul>
   *   <li>Then return Keys size is one.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#newTransactionForKeys(List)}
   */
  @Test
  @DisplayName("Test newTransactionForKeys(List); then return Keys size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbCacheTransaction CaffeineTbTransactionalCache.newTransactionForKeys(List)"})
  void testNewTransactionForKeys_thenReturnKeysSizeIsOne() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());

    ArrayList<CustomerCacheKey> keys = new ArrayList<>();
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    keys.add(customerCacheKey);

    // Act
    TbCacheTransaction<CustomerCacheKey, Customer> actualNewTransactionForKeysResult =
        customerCaffeineCache.newTransactionForKeys(keys);

    // Assert
    assertTrue(actualNewTransactionForKeysResult instanceof CaffeineTbCacheTransaction);
    List<CustomerCacheKey> keys2 =
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeysResult)
            .getKeys();
    assertEquals(1, keys2.size());
    assertFalse(
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeysResult)
            .isFailed());
    assertSame(keys, keys2);
    assertSame(customerCacheKey, keys2.get(0));
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#newTransactionForKeys(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Keys Empty.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#newTransactionForKeys(List)}
   */
  @Test
  @DisplayName("Test newTransactionForKeys(List); when ArrayList(); then return Keys Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbCacheTransaction CaffeineTbTransactionalCache.newTransactionForKeys(List)"})
  void testNewTransactionForKeys_whenArrayList_thenReturnKeysEmpty() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());

    // Act
    TbCacheTransaction<CustomerCacheKey, Customer> actualNewTransactionForKeysResult =
        customerCaffeineCache.newTransactionForKeys(new ArrayList<>());

    // Assert
    assertTrue(actualNewTransactionForKeysResult instanceof CaffeineTbCacheTransaction);
    assertFalse(
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeysResult)
            .isFailed());
    assertTrue(
        ((CaffeineTbCacheTransaction<CustomerCacheKey, Customer>) actualNewTransactionForKeysResult)
            .getKeys()
            .isEmpty());
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#commit(UUID, Map)}.
   *
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache} {@link
   *       CaffeineTbTransactionalCache#commit(UUID, Map)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#commit(UUID, Map)}
   */
  @Test
  @DisplayName(
      "Test commit(UUID, Map); given CaffeineTbTransactionalCache commit(UUID, Map) return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CaffeineTbTransactionalCache.commit(UUID, Map)"})
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnFalse_thenReturnFalse() {
    // Arrange
    when(caffeineTbTransactionalCache.commit(
            Mockito.<UUID>any(), Mockito.<Map<CustomerCacheKey, Customer>>any()))
        .thenReturn(false);
    UUID trId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    boolean actualCommitResult = caffeineTbTransactionalCache.commit(trId, new HashMap<>());

    // Assert
    verify(caffeineTbTransactionalCache).commit(isA(UUID.class), isA(Map.class));
    assertFalse(actualCommitResult);
  }

  /**
   * Test {@link CaffeineTbTransactionalCache#commit(UUID, Map)}.
   *
   * <ul>
   *   <li>Given {@link CaffeineTbTransactionalCache} {@link
   *       CaffeineTbTransactionalCache#commit(UUID, Map)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineTbTransactionalCache#commit(UUID, Map)}
   */
  @Test
  @DisplayName(
      "Test commit(UUID, Map); given CaffeineTbTransactionalCache commit(UUID, Map) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CaffeineTbTransactionalCache.commit(UUID, Map)"})
  void testCommit_givenCaffeineTbTransactionalCacheCommitReturnTrue_thenReturnTrue() {
    // Arrange
    when(caffeineTbTransactionalCache.commit(
            Mockito.<UUID>any(), Mockito.<Map<CustomerCacheKey, Customer>>any()))
        .thenReturn(true);
    UUID trId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    boolean actualCommitResult = caffeineTbTransactionalCache.commit(trId, new HashMap<>());

    // Assert
    verify(caffeineTbTransactionalCache).commit(isA(UUID.class), isA(Map.class));
    assertTrue(actualCommitResult);
  }
}
