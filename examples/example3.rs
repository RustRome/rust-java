
fn main() {
    let mut strings = vec!["test"];

    let _elem = strings.get(0);

    strings.remove(0);

    println!("{:?}", strings);

}


