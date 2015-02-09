import akka.actor.{ Props, ActorRef, ActorSystem, Actor }
import akka.contrib.pattern.{ ClusterSharding, ShardRegion }
import akka.persistence.PersistentActor

import scala.reflect.ClassTag

/**
 * Created by zoe on 2/9/15.
 */
object ShardCluster {
  /**
   * Starts a shard region for a given actor type
   * @param shardName The name of the shard region. This allows the region (via it's ActorRef) to be retrieved from the
   *                  ClusterSharding api.
   * @param actorSystem The actor system to start the shard region in.
   * @param idExtractor The idExtractor function to be used by the shard region. This function will extract actor IDs from
   *                    the messages to allow messages to be passed to the correct shard.
   * @param shardResolver The shardResolver function to be used by the shard region. This function will process the ID
   *                      and return the number of the shard the message should be handled by. It is recommended that there
   *                      be at least 10x more shards than nodes to allow for easy rebalancing of the cluster.
   * @tparam A The actor type the region will handle.
   * @return An ActorRef pointing to the shard region
   */
  def startShard[A <: Actor with PersistentActor: ClassTag](shardName: String)(implicit actorSystem: ActorSystem, idExtractor: ShardRegion.IdExtractor,
    shardResolver: ShardRegion.ShardResolver): ActorRef = {
    ClusterSharding(actorSystem).start(
      typeName = shardName,
      entryProps = Some(Props[A]),
      idExtractor = idExtractor,
      shardResolver = shardResolver
    )
  }
}
