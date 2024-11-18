Only file that is different is the Product.java.

# Performance and Scalability Considerations
## Time Complexity

#### Search Operation
The Red-Black tree operations are O(log n) because at each level, we eliminate half of the remaining nodes which is where the log n comes from and there is only one comparison done each step making it constant time. This means the time complexity is O(1) work and O(log n) levels resulting in a total O(log n).

#### Insert Operation
The insert operation in the Red-Black tree is O(log n) because it requires two main steps. First, we must find the insertion location which, like search, takes O(log n) as we eliminate half the nodes at each level with O(1) comparisons. After inserting, we may need to rebalance the tree through color changes and rotations, but these are constant time operations (O(1)) and can only occur up the path to the root (O(log n) levels). This means the total complexity is still O(log n) as both finding the position and rebalancing operate on O(log n) levels with O(1) work at each level.

## Large Dataset Performance
Performance with Large Datasets
The Red-Black BST maintains its O(log n) performance characteristics even with large datasets due to the tree's black height ensuring the path from root to leaf has the same number of black nodes, guaranteeing the tree height is logarithmic (≤ 2log(n+1)).
Also with n nodes, height remains O(log n) which means doubling the dataset size only adds one level to the tree height meaning the operations remain efficient even as data grows exponentially

## Balancing Analysis
The Red-Black BST maintains balance through specific properties and operations:

#### Balance Mechanism:
Red-black properties enforce approximate balance:
- Root is black
- Red nodes can't have red children
- Same number of black nodes on all root-to-leaf paths\
  
These properties prevent any path from being more than twice as long as others

#### Rebalancing Operations:

- Color flips: O(1) operation, changes node colors only
- Rotations: O(1) operation, reorganizes up to three nodes
- Both operations maintain the binary search property
- Maximum of O(log n) rebalancing operations per insert

#### Performance Impact:
- Insertion may trigger rebalancing up to the root: O(log n)
- Search operations benefit from balanced structure: O(log n)
- Small constant overhead from color checking
- A relaxed balance (Red-Black) favors more efficient insertions


# Output: 
/Users/justinpardo/Library/Java/JavaVirtualMachines/openjdk-23.0.1/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=62872:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /Users/justinpardo/IdeaProjects/A3/out/production/A3:/Users/justinpardo/IdeaProjects/Lab1/lib/algs4.jar:/Users/justinpardo/IdeaProjects/Lab1/lib/stdlib.jar Product
Added product: ID: Product Insert 1, Name: Headphones, Category: Collectibles, Price: $9.99
Product with ID 2144315a823e47df748abef74f8d68dc already exists

Product Search System
1. Search for a product by ID
2. Exit
Enter your choice: 1
Enter product ID: Product Insert 1
Product found: ID: Product Insert 1, Name: Headphones, Category: Collectibles, Price: $9.99

Product Search System
1. Search for a product by ID
2. Exit
Enter your choice: 1
Enter product ID: 2144315a823e47df748abef74f8d68dc
Product found: ID: 2144315a823e47df748abef74f8d68dc, Name: ,Imagine by Rubie's Star Wars VII: The Force Awakens Child's Finn Muscle Chest Shirt Costume Set,"Clothing, Shoes & Jewelry | Costumes & Accessories | Kids & Baby | Boys, Category: Costumes",, Price: $17.47

Product Search System
1. Search for a product by ID
2. Exit
Enter your choice: 1
Enter product ID: 8011ab02c41d95e3087bbb4040714118
Product found: ID: 8011ab02c41d95e3087bbb4040714118, Name: ,"Chenille Kraft Wonderfoam Foam Hopscotch Mat, Set of 14",Toys & Games | Puzzles, Category: Puzzle Play Mats,, Price: $24.45

Product Search System
1. Search for a product by ID
2. Exit
Enter your choice: 2

Process finished with exit code 0
