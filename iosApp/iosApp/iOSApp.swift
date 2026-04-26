import SwiftUI
import Shared

@main
struct iOSApp: App {

    init() {
        AppDiSetup.initKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}