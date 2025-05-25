package org.thingsboard.server.service.entitiy.queue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

@ExtendWith(MockitoExtension.class)
class DefaultTbQueueServiceDiffblueTest {
  @InjectMocks
  private DefaultTbQueueService defaultTbQueueService;

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();
    tenantIds.add(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, new TenantProfile());

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants2() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(3L);
    processingStrategy.setPauseBetweenRetries(3L);
    processingStrategy.setRetries(3);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(3L);
    tenantProfileQueueConfiguration.setPartitions(3);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(0.5d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES_AND_TIMED_OUT);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(1);
    submitStrategy2.setType(SubmitStrategyType.BATCH);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(false);
    tenantProfileQueueConfiguration2.setName("42");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration2.setPartitions(1);
    tenantProfileQueueConfiguration2.setPollInterval(3);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("42");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration2);
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(queueConfiguration);
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, new TenantProfile());

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_givenFalse() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(false);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile oldTenantProfile = mock(TenantProfile.class);
    when(oldTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(oldTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, oldTenantProfile);

    // Assert
    verify(oldTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
    verify(oldTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) MaxPauseBetweenRetries is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); given ProcessingStrategy (default constructor) MaxPauseBetweenRetries is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_givenProcessingStrategyMaxPauseBetweenRetriesIsFour() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(0.5d);
    processingStrategy2.setMaxPauseBetweenRetries(4L);
    processingStrategy2.setPauseBetweenRetries(4L);
    processingStrategy2.setRetries(4);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES_AND_TIMED_OUT);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(1);
    submitStrategy2.setType(SubmitStrategyType.BATCH);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration2 = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration2.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration2.setConsumerPerPartition(false);
    tenantProfileQueueConfiguration2.setName("42");
    tenantProfileQueueConfiguration2.setPackProcessingTimeout(4L);
    tenantProfileQueueConfiguration2.setPartitions(4);
    tenantProfileQueueConfiguration2.setPollInterval(1);
    tenantProfileQueueConfiguration2.setProcessingStrategy(processingStrategy2);
    tenantProfileQueueConfiguration2.setSubmitStrategy(submitStrategy2);
    tenantProfileQueueConfiguration2.setTopic("42");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration2);
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(queueConfiguration);
    TenantProfile oldTenantProfile = mock(TenantProfile.class);
    when(oldTenantProfile.getProfileData()).thenReturn(tenantProfileData2);
    when(oldTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, oldTenantProfile);

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(oldTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
    verify(oldTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) MaxPauseBetweenRetries is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); given ProcessingStrategy (default constructor) MaxPauseBetweenRetries is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_givenProcessingStrategyMaxPauseBetweenRetriesIsOne() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(1L);
    tenantProfileQueueConfiguration.setPartitions(1);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(queueConfiguration);
    TenantProfile oldTenantProfile = mock(TenantProfile.class);
    when(oldTenantProfile.getProfileData()).thenReturn(tenantProfileData2);
    when(oldTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, oldTenantProfile);

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(oldTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
    verify(oldTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) MaxPauseBetweenRetries is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); given ProcessingStrategy (default constructor) MaxPauseBetweenRetries is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_givenProcessingStrategyMaxPauseBetweenRetriesIsThree() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(3L);
    processingStrategy.setPauseBetweenRetries(3L);
    processingStrategy.setRetries(3);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    TenantProfileQueueConfiguration tenantProfileQueueConfiguration = new TenantProfileQueueConfiguration();
    tenantProfileQueueConfiguration.setAdditionalInfo(MissingNode.getInstance());
    tenantProfileQueueConfiguration.setConsumerPerPartition(true);
    tenantProfileQueueConfiguration.setName("Name");
    tenantProfileQueueConfiguration.setPackProcessingTimeout(3L);
    tenantProfileQueueConfiguration.setPartitions(3);
    tenantProfileQueueConfiguration.setPollInterval(42);
    tenantProfileQueueConfiguration.setProcessingStrategy(processingStrategy);
    tenantProfileQueueConfiguration.setSubmitStrategy(submitStrategy);
    tenantProfileQueueConfiguration.setTopic("Topic");

    ArrayList<TenantProfileQueueConfiguration> queueConfiguration = new ArrayList<>();
    queueConfiguration.add(tenantProfileQueueConfiguration);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(queueConfiguration);
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, new TenantProfile());

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); when ArrayList(); then calls getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_whenArrayList_thenCallsGetProfileData() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    TenantProfileData tenantProfileData2 = new TenantProfileData();
    tenantProfileData2.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData2.setQueueConfiguration(new ArrayList<>());
    TenantProfile oldTenantProfile = mock(TenantProfile.class);
    when(oldTenantProfile.getProfileData()).thenReturn(tenantProfileData2);
    when(oldTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, oldTenantProfile);

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(oldTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
    verify(oldTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); when 'null'; then calls getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_whenNull_thenCallsGetProfileData() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, null);

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
  }

  /**
   * Test {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}.
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbQueueService#updateQueuesByTenants(List, TenantProfile, TenantProfile)}
   */
  @Test
  @DisplayName("Test updateQueuesByTenants(List, TenantProfile, TenantProfile); when TenantProfile(); then calls getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbQueueService.updateQueuesByTenants(List, TenantProfile, TenantProfile)"})
  void testUpdateQueuesByTenants_whenTenantProfile_thenCallsGetProfileData() {
    // Arrange
    ArrayList<TenantId> tenantIds = new ArrayList<>();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile newTenantProfile = mock(TenantProfile.class);
    when(newTenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(newTenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);

    // Act
    defaultTbQueueService.updateQueuesByTenants(tenantIds, newTenantProfile, new TenantProfile());

    // Assert
    verify(newTenantProfile).getProfileData();
    verify(newTenantProfile).isIsolatedTbRuleEngine();
  }
}
