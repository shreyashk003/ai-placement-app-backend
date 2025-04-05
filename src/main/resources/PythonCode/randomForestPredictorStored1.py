# Import necessary libraries
import sys
import joblib
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score

print("I am RF")
# Load data from CSV file
df = pd.read_csv('D:\\randomForestData1.csv')  # Replace 'your_data.csv' with your actual CSV file name

#df = pd.read_csv('e:\sjbit\python\studentPerformanceDataTrainingFinal.csv')  
# Replace 'your_data.csv' with your actual CSV file name
# Assuming the last column is the target variable
X = df.iloc[:, :-1]  # Features
y = df.iloc[:, -1]   # Target variable

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.25, random_state=43)

# Create a RandomForestClassifier
forest_classifier = joblib.load("D:\\fClassifier.joblib")

# Train the model on the training set
#forest_classifier.fit(X_train, y_train)

# Make predictions on the testing set
y_pred = forest_classifier.predict(X_test)

print(sys.argv)
if len(sys.argv) != 20:
    print("Please provide exactly 20 values as command-line arguments.")
    sys.exit(1)

# Parse command-line arguments as float values
try:
    single_sample = [float(arg) for arg in sys.argv[1:]]
except ValueError:
    print("Invalid input. Please provide numeric values.")
    sys.exit(1)

# Test the single sample
predicted_class = forest_classifier.predict([single_sample])

# Evaluate the model
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy}")

print(predicted_class[0])

#joblib.dump(forest_classifier,"fClassifier.joblib")