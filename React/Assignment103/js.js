var product = [
    {
        id: 1,
        title: "Product 1 Lorem color",
        description: "Lorem ipsum color sit amet consectetur fugiat",
        submitterAvatar: "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
        productImage: "https://png.pngtree.com/png-clipart/20210608/ourlarge/pngtree-dark-gray-simple-avatar-png-image_3418404.jpg"
    },
    {
        id: 2,
        title: "Product 2 Lorem color",
        description: "Lorem ipsum color sit amet consectetur fugiat",
        submitterAvatar: "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
        productImage: "https://png.pngtree.com/png-clipart/20210608/ourlarge/pngtree-dark-gray-simple-avatar-png-image_3418404.jpg"
    },
    {
        id: 3,
        title: "Product 3 Lorem color",
        description: "Lorem ipsum color sit amet consectetur fugiat",
        submitterAvatar: "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
        productImage: "https://png.pngtree.com/png-clipart/20210608/ourlarge/pngtree-dark-gray-simple-avatar-png-image_3418404.jpg"
    },
    {
        id: 4,
        title: "Product 4 Lorem color",
        description: "Lorem ipsum color sit amet consectetur fugiat",
        submitterAvatar: "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
        productImage: "https://png.pngtree.com/png-clipart/20210608/ourlarge/pngtree-dark-gray-simple-avatar-png-image_3418404.jpg"
    },
    {
        id: 5,
        title: "Product 5 Lorem color",
        description: "Lorem ipsum color sit amet consectetur fugiat",
        submitterAvatar: "https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg",
        productImage: "https://png.pngtree.com/png-clipart/20210608/ourlarge/pngtree-dark-gray-simple-avatar-png-image_3418404.jpg"
    },
]

function Header() {
    return (
        <h2 className="header">Lorem product list</h2>
    )
}

function Footer(){
    return(
        <div className="footer">
            <p>Footer this page</p>
        </div>
    )
}

function Content({element}) {
    return (
        <div>
            <div className="row">
                <div className="col-md-3 col-sm-6">
                    <img src={element.submitterAvatar} alt="Avartar"/>
                </div>
                <div className="col-md-9 col-sm-6">
                    <h5>{element.title}</h5>
                    <p>{element.description}</p>
                    <p className="submit-by">Submit by: <div className="image"><img src={element.productImage} alt=""/>
                    </div></p>
                    <button onClick={() =>{
                        alert("You click: " +element.title)
                    }}>
                        Click
                    </button>
                </div>
            </div>
            <br/>
        </div>
    )
}

function App() {
    return (
        <div className="container">
            <Header/>
            {product.map((element, index) => (
                <Content
                    key={index}
                    element={element}
                />
            ))}
            <Footer/>
        </div>
    )
}

ReactDOM.render(<App/>, document.getElementById('root'))