# LiveData-ViewModel

> 以上代码中：app1实例有些小问题，待更新
* LiveData是一个数据持有类，他可以通过观察者被其他组件观察其变更
* LiveData的优点：不用手动控制生命周期，不用担心内存泄露，数据变化时会收到通知。
* ViewModel的优点也很明显,为Activity 、Fragment存储数据，直到完全销毁，所以ViewModel可以在当前Activity的Fragment中实现数据共享。

# 添加依赖：
>   implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
