import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
import tensorflow as tf

'''
https://stackabuse.com/k-nearest-neighbors-algorithm-in-python-and-scikit-learn/

Test_fearMat_Clean: 4168
    Before edit: 4231 rows × 34 columns
    After edit: 4168 rows × 34 columns
    
    #removed 6 to 7
    total = 3749
    

Train_fearMat_Clean: 16680
    Before edit: 16927 rows × 34 columns
    After edit: 16680 rows × 34 columns
    
    #removed 6 to 7
    total = 15045

'''

import os
print(os.listdir(r"C:\Users\eddie\OneDrive\Desktop\CISC 4900"))         #print out what's in the file/directory

train = pd.read_csv(r"C:\Users\eddie\OneDrive\Desktop\CISC 4900\Test_featMat_Clean.csv")         #using test


test = pd.read_csv(r"C:\Users\eddie\OneDrive\Desktop\CISC 4900\Train_featMat_Clean.csv")         #will use later code works


#print
train.head()

#describe the column
train.describe()

#print out the lables/column and there datatype
train.dtypes


#prints the selected columns
train_knn = train[['User_ID', 'Doc_ID', 'Phone_ID', 'Ratio dist and length of trajectory', 'Average velocity', 'Phone orientation']]
train_knn.head()

#display the dtype of the select column
train_knn.dtypes



'''
Choosing a specific columns to use for now
'''
#prints the selected columns
train_knn = train[['User_ID', 'Doc_ID', 'Phone_ID', 'Ratio dist and length of trajectory', 'Average velocity', 'Phone orientation']]
train_knn.head()


#The X variable contains the first five columns of the dataset (i.e. attributes) while y contains the labels.
#5 columns and 1 label
X = train_knn.iloc[:, :-1].values         #contain all columns except the last one
y = train_knn.iloc[:, 5].values         #contains the labels, 5 for test, but 33 for the whole test


#Train and test split
#80% train, 20% test
#splitting the data into test and train dataset

from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.20)


#Feature Scaling
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()
scaler.fit(X_train)

X_train = scaler.transform(X_train)
X_test = scaler.transform(X_test)


#Training and Prediction
from sklearn.neighbors import KNeighborsClassifier
classifier = KNeighborsClassifier(n_neighbors=5)         #value for k
classifier.fit(X_train, y_train)



#Make prediction on the test data
y_pred = classifier.predict(X_test)

#Evaluating the Algorithm
from sklearn.metrics import classification_report, confusion_matrix
print(confusion_matrix(y_test, y_pred))
print(classification_report(y_test, y_pred))


#will print out the accuracy of the test set
#accuracy
    #macro avg: 87.75
    #weighted avg: 97.25



'''
Plotting the result in a graph
'''
#Comparing error rate with the K value
error = []

# Calculating error for K values between 1 and 100
for i in range(1, 100):
    knn = KNeighborsClassifier(n_neighbors=i)
    knn.fit(X_train, y_train)
    pred_i = knn.predict(X_test)
    error.append(np.mean(pred_i != y_test))
#plotting the result in a graph
import matplotlib.pyplot as plt

plt.figure(figsize=(12, 10))
plt.plot(range(1, 100), error, color='red', linestyle='dashed', marker='o',
         markerfacecolor='blue', markersize=10)
plt.title('Error Rate K Value')
plt.xlabel('K Value')
plt.ylabel('Mean Error')
