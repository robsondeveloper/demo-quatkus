package quarkus.recursion;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.Collections;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = Logger.getLogger("ListenerBean");

    void onStart(@Observes StartupEvent ev) {
        LOGGER.info("The application is starting...");
        init();
    }

    void onStop(@Observes ShutdownEvent ev) {
        LOGGER.info("The application is stopping...");
    }

    void init() {
        var node5 = new Node(5L, "node 5", Collections.emptyList());
        var node4 = new Node(4L, "node 4", Collections.emptyList());

        var nodesLevel3 = new ArrayList<Node>();
        nodesLevel3.add(node4);
        nodesLevel3.add(node5);

        var node3 = new Node(3L, "node 3", Collections.emptyList());
        var node2 = new Node(2L, "node 2", nodesLevel3);

        var nodesLevel2 = new ArrayList<Node>();
        nodesLevel2.add(node2);
        nodesLevel2.add(node3);

        var node1 = new Node(1L, "node 1", nodesLevel2);
        recursive(node1);
    }

    void recursive(Node node) {
        var nodes = node.getNodes();
        for (Node n : nodes) {
            LOGGER.info(node.getName() + " - " + n.getName());
            recursive(n);
        }
    }

}
